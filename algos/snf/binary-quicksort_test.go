package snf

import (
	"reflect"
	"testing"
)

// TestSortNone calls snf.Sort with an empty array,
// expects no return value.
func TestSortNone(t *testing.T) {
	sorted := Sort([]int{})
	want := []int{}

	if !reflect.DeepEqual(sorted, want) {
		t.Fatalf(`Sort(sorted) = %v, want %v`, sorted, want)
	}
}

// TestSortBase calls snf.Sort with a base case array for quicksort,
// expects the array to be returned.
func TestSortBase(t *testing.T) {
	sorted := Sort([]int{1})
	want := []int{1}

	if !reflect.DeepEqual(sorted, want) {
		t.Fatalf(`Sort(sorted) = %v, want %v`, sorted, want)
	}
}

// TestSortValid calls snf.Sort with an array of any length in any order,
// expects the array to be returned in sorted order from low to high.
func TestSortValid(t *testing.T) {
	sorted := Sort([]int{5, 46, 3, 2, 100})
	want := []int{2, 3, 5, 46, 100}

	if !reflect.DeepEqual(sorted, want) {
		t.Fatalf(`Sort(sorted) = %v, want %v`, sorted, want)
	}
}

// // TestSearch calls snf.Search...
// func TestSearch(t *testing.T) {}
