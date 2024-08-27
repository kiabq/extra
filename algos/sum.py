def rsum(arr):
    return arr.pop(0) + sum(arr)

def main():
    arr = [1, 2, 3]
    t = rsum(arr)

if __name__ == "__main__":
    main()
