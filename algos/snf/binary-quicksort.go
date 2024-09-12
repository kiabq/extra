package snf

import (
	"math/rand/v2"
)

// Sort will sort a slice from low to high using the quicksort algorithm.
func Sort(arr []int) []int {
	// choose a pivot
	// return if length is one or less. (base case)
	// otherwise, sort the array.
	if len(arr) < 2 {
		return arr
	} else {
		pivot := rand.IntN(len(arr))
		lesser := make([]int, 0)
		greater := make([]int, 0)

		search := arr[:pivot]
		search = append(search, arr[pivot:]...)

		for i := 0; i < len(arr); i++ {
			if i == pivot {
				continue
			}

			if arr[i] <= arr[pivot] {
				lesser = append(lesser, arr[i])
			} else if arr[i] > arr[pivot] {
				greater = append(greater, arr[i])
			}
		}

		return append(Sort(lesser), append([]int{arr[pivot]}, Sort(greater)...)...)
	}
}

// Search will find a given number in a slice.
func Search(arr []int) {
}
