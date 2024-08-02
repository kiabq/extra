package main

import "fmt"

// Get greatest common divisor
// p - numerator
// q - denominator
// r - remainder
func gcd(p int, q int) int {
	if q == 0 {
		return p
	}
	r := p % q

	return gcd(q, r)
}

func main() {
	// In this example, we start with 100 and 9.
	// First, we do 100 mod 9. This will equal 99 with a remainder of 1.
	// So, our new variables are going to be passed to gcd recursively as
	// p = 9 and q = 1.
	// 9 mod 1 is 0, so our new variables are p = 1 and q = 0.
	// Because q is now 0, we return p, or 1.
	fmt.Println(gcd(100, 9))
}
