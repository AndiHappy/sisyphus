package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
)

type indexLetter struct {
	index int
	c     rune
}

func main() {
	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		chars := []rune(input.Text())
		otherChars := make([]bool, len(chars))
		letters := []indexLetter{}
		for i, c := range chars {
			if c < 'A' || (c > 'Z' && c < 'a') || c > 'z' {
				otherChars[i] = true
			} else {
				il := indexLetter{i, c}
				letters = append(letters, il)
			}
		}
		plus := 'a' - 'A'
		sort.Slice(letters, func(i, j int) bool {
			if math.Abs(float64(letters[i].c-letters[j].c)) == float64(plus) || letters[i].c == letters[j].c {
				return letters[i].index < letters[j].index
			}
			ti, tj := letters[i].c, letters[j].c
			if ti >= 'a' {
				ti -= plus
			}
			if tj >= 'a' {
				tj -= plus
			}
			return ti < tj
		})
		for i, c := range chars {
			if otherChars[i] == true {
				fmt.Print(string(c))
			} else {
				fmt.Print(string(letters[0].c))
				letters = letters[1:len(letters)]
			}
		}
	}

}
