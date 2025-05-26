# RAG-OPENAI-DEMO Project

This is a demo project to blog post https://www.antoniyaattech.com/posts/blog-rag-openai-spring-ai/

## Import the project into your IDE of choice

## Adjust the configuration

Open `src/main/resources/application.yaml` and update the following properties with your data from Azure:
* `spring.ai.azure.openai.api-key` 
* `spring.ai.azure.openai.endpoint`

## Project Build

From the command line, execute `gradlew clean build`. A 'BUILD SUCCESSFUL' message should appear if the build completes successfully.

## Project Run

1. First start the Database with the provided `docker-compose.yaml` file. In a new terminal window, execute `docker compose up`. Make sure Docker is installed in your development environment.
2. Next, start the Spring Boot application by running the Gradle task `gradlew bootRun`.

## Sending First Request with curl

Here are some example Requests/Responses to test the application. Please note that the responses from the LLM may vary slightly.

### Example 1

* Request
`curl -G localhost:8091/recipe-recommendation --data-urlencode "prompt='I am looking for the healthies dessert.'"`

* Response
```json
{
  "originalPrompt":"'I am looking for the healthies dessert.'",
  "searchResult":"The healthiest dessert option from the context provided is the vegan carrot cake with dark chocolate."
}
```

### Example 2

* Request
`curl -G localhost:8091/recipe-recommendation --data-urlencode "prompt='I am looking for a cheesecake recommendation.'"`

* Response
```json
{
  "originalPrompt":"'I am looking for a cheesecake recommendation.'",
  "searchResult":"I'm sorry, but I can't provide a cheesecake recommendation based on the information provided."
}
``` 
  
