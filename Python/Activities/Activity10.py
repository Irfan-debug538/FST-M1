user_input = input('Enter space-separated integers: ')
my_tuple = tuple(int(item) for item in user_input.split())
print(my_tuple)
for i in my_tuple:
    if (i%5==0):
        print(i)