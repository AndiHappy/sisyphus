package main

import (
	"bufio"
	"fmt"
	"os"
)

// 26
func main() {
	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		input_copy := make([]byte, len(input.Text())) // 负责存字母位置和非英文字符
		copy(input_copy, []byte(input.Text()))

		output := make([]byte, 0) // 负责存排序好的字母
		for i := 0; i < 26; i++ {
			// 每个字母遍历一遍输入的字符
			for j, value := range input_copy {
				if int(value) == 'a'+i || int(value) == 'A'+i {
					output = append(output, value) // 按照大小顺序加入
					input_copy[j] = 'a'            // a做占位符
				}
			}
		}
		// 重新填入
		i := 0
		for k, v := range input_copy {
			if v == 'a' {
				input_copy[k] = output[i]
				i++
			}
		}
		fmt.Println(string(input_copy))
	}
}
