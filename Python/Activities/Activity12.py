def recursive_add(num):
    if num !=0 :
        return num+recursive_add(num-1)
    else:
        return 0


result_add=recursive_add(10)
print(result_add)