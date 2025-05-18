# rag-openai-demo

curl -G localhost:8091/recipe-recommendation --data-urlencode "prompt='I am looking for the healthies dessert.'"

{"originalPrompt":"'I am looking for the healthies dessert.'","searchResult":"The healthiest dessert option from the context provided is the vegan carrot cake with dark chocolate."}%  

curl -G localhost:8091/recipe-recommendation --data-urlencode "prompt='I am looking for a desser
t based on traditional recipe.'"

{"originalPrompt":"'I am looking for a dessert based on traditional recipe.'","searchResult":"Based on the traditional recipes mentioned in the context, you might enjoy the cardamom cinnamon rolls. They are a delightful dessert option that incorporates traditional flavors. If you're looking for something healthier, the vegan carrot cake with dark chocolate is also a great choice. Let me know if you need more information!"}%  

curl -G localhost:8091/recipe-recommendation --data-urlencode "prompt='I am looking for a cheese
cake recommendation.'"

{"originalPrompt":"'I am looking for a cheesecake recommendation.'","searchResult":"I'm sorry, but I can't provide a cheesecake recommendation based on the information provided."}%   