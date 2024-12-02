package main

import (
	selection_sort "aoc/2024/lib"
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
	left := make([]int, 0)
	right := make([]int, 0)

	sum := 0

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

	left = selection_sort.Sort(left)
	right = selection_sort.Sort(right)

	// Unnecessary comparison... LETS GOOOOOOOOO
	if len(left) == len(right) {
		len := len(left)
		var dist int
		for i := 0; i < len; i++ {
			diff := math.Abs(float64(left[i]) - float64(right[i]))
			dist = int(diff)

			sum += dist
		}
	}

	fmt.Println(sum)
}
