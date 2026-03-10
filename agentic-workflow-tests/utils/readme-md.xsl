<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="3.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    expand-text="yes">
<xsl:output method="text"/>
<xsl:strip-space elements="*"/>
<xsl:template match="/TestSpec">
# {Id}. {Title}


**Category:** {Category}  
**Complexity:** {Complexity}  
**Repository:** [{CodeRepository}]({CodeRepository})  

---

## Stack

### Languages
<xsl:for-each select="Stack/Languages/Language">
- <xsl:choose><xsl:when test="@primary = 'true'">**{.}** (primary)</xsl:when><xsl:otherwise>{.}</xsl:otherwise></xsl:choose>
</xsl:for-each>

### Technologies
<xsl:choose>
<xsl:when test="not(Stack/Technologies/Technology)">
N/A
</xsl:when>
<xsl:otherwise>
<xsl:for-each select="Stack/Technologies/Technology">
- {.}</xsl:for-each>
</xsl:otherwise>
</xsl:choose>

## Task

```md
{replace(Task, '^[\s\n\r]+|[\s\n\r]+$', '')}
```

## Context

### Files
<xsl:for-each select="Context/Files/File">
- `{.}`</xsl:for-each>

## Arrangement
<xsl:choose>
<xsl:when test="not(Arrangement/Arrange)">
N/A
</xsl:when>
<xsl:otherwise>
<xsl:for-each select="Arrangement/Arrange">
- {replace(., '^[\s\n\r]+', '')}</xsl:for-each>
</xsl:otherwise>
</xsl:choose>

## Act
<xsl:for-each select="Act/ActStep">
- {replace(., '^[\s\n\r]+', '')}</xsl:for-each>


## Testing
<xsl:for-each select="TestPlan/TestStep">
- {replace(., '^[\s\n\r]+', '')}</xsl:for-each>

## Assertion

The generated solution is asserted against the criteria given below:

<xsl:for-each select="Criteria/Criterion">
- **{@type}** ({if (@weight) then concat('==', @weight, '==') else '==high=='}){if (@comment) then concat(': __', @comment, '__') else ''}<xsl:for-each select="./Assert">
    - ({if (@weight) then concat('==', @weight, '==') else '==high=='}) {replace(., '^[\s\n\r]+', '')}</xsl:for-each></xsl:for-each>

## Additional Notes
<xsl:choose>
<xsl:when test="not(MetaInfo/Meta)">
N/A
</xsl:when>
<xsl:otherwise>
<xsl:for-each select="MetaInfo/Meta">
- {replace(., '^[\s\n\r]+', '')}</xsl:for-each>
</xsl:otherwise>
</xsl:choose>

</xsl:template>

</xsl:stylesheet>