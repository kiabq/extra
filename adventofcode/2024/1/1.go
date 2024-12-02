package main

import (
	"fmt"

	"aoc/2024/lib/selection_sort"
)

func main() {
	fmt.Println("1")

	temp := []int{5, 4, 3, 2, 1}

	selection_sort.Sort(temp)
}
