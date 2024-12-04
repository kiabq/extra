package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
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
		safe := true

		var prev int64
		var diff int
		var increasing bool
		min, max := 1, 3
		for i, v := range values {
			curr, _ := strconv.ParseInt(v, 10, 0)

			if i == 1 {
				if curr > prev {
					increasing = true
				}
			}

			if i > 0 && safe == true {
				if curr == prev {
					safe = false
					break
				}

				if increasing == true && curr < prev {
					safe = false
					break
				}

				if increasing == false && curr > prev {
					safe = false
					break
				}

				diff = int(math.Abs(float64(curr - prev)))
				if diff < min || diff > max {
					safe = false
					break
				}
			}

			prev = curr
		}

		if safe == true {
			sum++
		}

		fmt.Println(sum)
	}
}
