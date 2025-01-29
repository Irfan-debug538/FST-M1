fruits= {
    "orange":15,
    "mango":50,
    "apple": 61,
    "guava":10
}
user_fruit = input("which fruit you want")
if ( user_fruit in fruits):
    print("available")
else:
    print("not available")