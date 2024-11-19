package com.golf.app.spring;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import com.golf.app.model.RoundScore;

import de.siegmar.fastcsv.writer.CsvWriter;

/**
 * Implementation of {@link HttpMessageConverter} that can write a single
 * {@link RoundScore} or Collections of {@link RoundScore RoundScores} in CSV
 * format.
 *
 */
public class RoundScoreCsvHttpMessageConverter extends AbstractGenericHttpMessageConverter<Object>
{
    public static final String TEXT_CSV_VALUE = "text/csv";
    public static final MediaType TEXT_CSV = new MediaType( "text", "csv" );

    private static final String[] CSV_HEADERS = new String[]
    {
            "Id", "Date", "Player", "HCP", "Competition", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "Stroke", "Penalty", "GrossScore", "NetScore", "NetScorePar",
            "Stableford"
    };

    public RoundScoreCsvHttpMessageConverter()
    {
        super( TEXT_CSV );
    }

    @Override
    public boolean canRead( Class<?> clazz, @Nullable MediaType mediaType )
    {
        return false;
    }

    @Override
    public boolean canRead( Type type, @Nullable Class<?> contextClass, @Nullable MediaType mediaType )
    {
        return false;
    }

    @Override
    public Object read( Type type, @Nullable Class<?> contextClass, HttpInputMessage inputMessage )
            throws IOException, HttpMessageNotReadableException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected RoundScore readInternal( Class<?> clazz, HttpInputMessage inputMessage )
            throws IOException, HttpMessageNotReadableException
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean canWrite( Class<?> clazz, @Nullable MediaType mediaType )
    {
        return canWrite( clazz, null, mediaType );
    }

    @Override
    public boolean canWrite( @Nullable Type type, @Nullable Class<?> clazz, @Nullable MediaType mediaType )
    {
        if( !(type instanceof ParameterizedType parameterizedType) )
        {
            return (type instanceof Class<?> c && RoundScore.class.isAssignableFrom( c ));
        }
        if( !(parameterizedType.getRawType() instanceof Class<?> rawType) )
        {
            return false;
        }
        if( !(Collection.class.isAssignableFrom( rawType )) )
        {
            return false;
        }
        if( parameterizedType.getActualTypeArguments().length != 1 )
        {
            return false;
        }
        Type typeArgument = parameterizedType.getActualTypeArguments()[0];
        if( !(typeArgument instanceof Class<?> typeArgumentClass) )
        {
            return false;
        }
        return RoundScore.class.isAssignableFrom( typeArgumentClass );
    }

    @Override
    protected void writeInternal( Object object, @Nullable Type type, HttpOutputMessage outputMessage )
            throws IOException, HttpMessageNotWritableException
    {

        if( object instanceof RoundScore roundScore )
        {
            write( roundScore, outputMessage );
        }
        else
        {
            @SuppressWarnings("unchecked")
            Collection<RoundScore> roundScores = (Collection<RoundScore>) object;
            if( roundScores.size() == 1 )
            {
                write( roundScores.iterator().next(), outputMessage );
            }
            else
            {
                writeCollection( roundScores, outputMessage );
            }
        }
    }

    private void write( RoundScore roundScore, HttpOutputMessage outputMessage ) throws IOException
    {
        Assert.notNull( roundScore, "RoundScore must not be null" );

        OutputStream out = outputMessage.getBody();

        try (CsvWriter csvWriter = csvWriter( out ))
        {
            String[] fields = fields( roundScore );
            csvWriter.writeRecord( fields );
        }
    }

    private void writeCollection( Collection<RoundScore> roundScores,
            HttpOutputMessage outputMessage ) throws IOException
    {
        Assert.notNull( roundScores, "Collection of RoundScore should not be null" );

        OutputStream out = outputMessage.getBody();

        try (CsvWriter csvWriter = csvWriter( out ))
        {
            csvWriter.writeRecord( CSV_HEADERS );
            for( RoundScore roundScore : roundScores )
            {
                String[] fields = fields( roundScore );
                csvWriter.writeRecord( fields );
            }
        }
    }

    private CsvWriter csvWriter( OutputStream out )
    {
        CsvWriter csvWriter = CsvWriter.builder().build( new BufferedWriter( new OutputStreamWriter( out ) ) );
        return csvWriter;
    }

    private String[] fields( RoundScore roundScore )
    {
        String[] fields = new String[CSV_HEADERS.length];
        int i = 0;
        // Id
        fields[i++] = String.valueOf( roundScore.getId() );
        //Date
        fields[i++] = String.valueOf( roundScore.getDate() );
        // Player
        fields[i++] = roundScore.getPlayer().getSurname() + " " + roundScore.getPlayer().getName();
        // HCP
        fields[i++] = String.valueOf( roundScore.getPlayer().getHcp() );
        // Competition
        fields[i++] = roundScore.getCompetition().getName();
        // 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18
        int scoresLength = roundScore.getScores().size();
        for( int j = 0; j < 18; j++ )
        {
            fields[i++] = j < scoresLength ? String.valueOf( roundScore.getScores().get( j ).getStroke() ) : "";
        }
        // Stroke
        fields[i++] = String.valueOf( roundScore.getSumStroke() );
        //Penalty
        fields[i++] = String.valueOf( roundScore.getSumPenalty() );
        // GrossScore
        fields[i++] = String.valueOf( roundScore.getSumGrossScore() );
        // NetScore
        fields[i++] = String.valueOf( roundScore.getSumNetScore() );
        // NetScorePar
        fields[i++] = String.valueOf( roundScore.getSumNetScorePar() );
        // Stableford
        fields[i++] = String.valueOf( roundScore.getSumStableford() );
        return fields;
    }

}
