import math

def quicksort(arr):
    # base case
    arr_len = len(arr)
    
    if arr_len < 2:
        return arr
    else:
        pivot = arr[0] 
        
        less = [i for i in arr[1:] if i <= pivot]
        greater = [i for i in arr[1:] if i > pivot]

        return quicksort(less) + [pivot] + quicksort(greater)

input1 = []
input2 = [1]
input3 = [5, 2]
input4 = [33, 10, 15, 7]
input5 = [33, 10, 5, 15, 3]

r1 = quicksort(input1)
r2 = quicksort(input2)
r3 = quicksort(input3)
r4 = quicksort(input4)
r5 = quicksort(input5)

print(r1, r2, r3, r4, r5)
# []
# [1]
# [2, 5]
# [7, 10, 15, 33]
# [3, 5, 10, 15, 33]
