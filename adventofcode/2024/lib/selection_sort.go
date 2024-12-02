package selection_sort

func Sort(list []int) []int {
	sorted := make([]int, len(list))
	copy(sorted, list)

	for i := 0; i < len(list)-1; i++ {
		var min int = i
		var temp int

		for j := 1; j < len(list)+1; j++ {
			if sorted[j] < sorted[min] {
				min = j
			}
		}

		// Swap elements
		temp = sorted[i]
		sorted[i] = sorted[min]
		sorted[min] = temp
	}

	return sorted
}
