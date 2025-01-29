def Add_print(list1):
   # list1=list(input("enter input values")).split(", ") 
    sum=0
    for i in list1:
        sum=sum+i
    return sum

result_list=[1,2,3,4,5,6,7,8]
sum_elements=Add_print(result_list)
print(str(sum_elements))