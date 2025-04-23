**Algorithm code commenting test**

*Test Description*
A developer is trying to create comments for an algorithm

*Act*

<details>
<summary>Bare LLM testing instructions:</summary>

- Open the prompt.txt file
- Copy a question located in the prompt.txt file to the chat window
- Submit the question
- Open the project code-explanation/algorithm-code-comments/C#

</details>

<details>
<summary>Chat IDE:</summary>

- Open the project code-explanation/algorithm-code-comments/C#
- Open the GaussKrugerEvaluator class
- Highlight the GaussKrugerToWGS84 method
- Type in the chat window:

```
Add comments to the GaussKrugerToWGS84 method. It should be a detailed description of the algorithm
```

</details>

*Assert conditions*

Compare the generated comments with the comments in the correctResponse.txt file

*Additional note*

The correct solutions is in the correctResponse.txt file