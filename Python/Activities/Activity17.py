import pandas
 
# Create a Dictionary that will hold our data
data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe = pandas.DataFrame(data)
 
print(dataframe)
 
dataframe.to_csv("sample.csv", index=False)