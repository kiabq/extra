def find_smallest(arr):
    smallest = arr[0]
    smallest_index = 0 
    for idx, _ in enumerate(arr):
        if smallest > arr[idx]:
            smallest = arr[idx]
            smallest_index = idx 
    return smallest_index

def selection_sort(arr):
    fin = []

    print(arr)

    for i in range(len(arr)):
        smallest = find_smallest(arr)
        fin.append(arr.pop(smallest))

    print(fin)

selection_sort([])
selection_sort([0, 5, 3, 10, 11, 51, 2, 52, 4])
selection_sort([10, 9, 8, 7, 6, 5, 4, 3, 2, 1])
