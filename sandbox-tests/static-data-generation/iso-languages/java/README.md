**ISO languages generation test**

*Test Description*

A developer is trying to generate two letter ISO languages codes and corresponding language names

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project static-data-generation/iso-languages/java

</details>

<details>
<summary>Code Completion instructions:</summary>

- Open the project static-data-generation/iso-languages/java in IDE
- Open the Languages.csv file
- Type in the file:

```
ISO-Code,Language
aa,Afar
ab,Abkhazian
```

- Press ENTER
- Accept a sequence of suggestions using the TAB and ENTER keys

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project static-data-generation/iso-languages/java
- Open the Languages.csv file
- Type in the chat window:

```
Generate all ISO two-letter language codes and corresponding language names in CSV format
```

</details>

*Assert conditions*

- Code must compile
- ISO languages codes must be generated

*Additional note*

The correct solutions is in the correctResponse.txt file. Please note, that a language can have an alternate name or spelling may differ. See https://www.loc.gov/standards/iso639-2/ISO-639-2_utf-8.txt for details.