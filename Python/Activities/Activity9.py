list1=[2,3,4,5,6,1]
list2=[7,8,9,1,5,6,4]
result_list=[]

for i in list1:
    if(i%2!=0):
        result_list.append(i)
for j in list2:
    if(j%2==0):
        result_list.append(j)

print(result_list)
