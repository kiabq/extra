package main

import (
	selection_sort "aoc/2024/lib"
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Tracker struct {
	count  int
	occurs int
}

func main() {
	left := make([]int, 0)
	right := make([]int, 0)

	tracker := make(map[int]Tracker)
	similarity := 0

	// Using relative dir ¯\_(ツ)_/¯
	file, err := os.Open("../input.txt")
	if err != nil {
		panic(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)

	for scanner.Scan() {
		values := strings.Fields(scanner.Text())

		l, _ := strconv.Atoi(values[0])
		left = append(left, l)

		r, _ := strconv.Atoi(values[1])
		right = append(right, r)
	}

	// Could index the map here, but I don't wanna.
	left = selection_sort.Sort(left)
	right = selection_sort.Sort(right)

	// Unnecessary comparison... LETS GOOOOOOOOO
	if len(left) == len(right) {
		len := len(left)
		for i := 0; i < len; i++ {

			// God, I'm so fucking stupid
			v, ok := tracker[left[i]]
			if !ok {
				tracker[left[i]] = Tracker{
					count:  1,
					occurs: 0,
				}
			} else {
				tracker[left[i]] = Tracker{
					count:  v.count + 1,
					occurs: v.occurs,
				}
			}

			v, ok = tracker[right[i]]
			if !ok {
				tracker[right[i]] = Tracker{
					count:  0,
					occurs: 1,
				}
			} else {
				tracker[right[i]] = Tracker{
					count:  v.count,
					occurs: v.occurs + 1,
				}
			}
		}
	}

	for k, v := range tracker {
		if v.occurs > 0 && v.count > 0 {
			for i := 0; i < v.count; i++ {
				similarity += k * v.occurs
			}
		}
	}

	fmt.Println(similarity)
}
