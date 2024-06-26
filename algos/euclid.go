package main

// Get greatest common divisor
func gcd(p int, q int) int {
	if q == 0 {
		return p
	}
	r := p % q
	return gcd(q, r)
}
