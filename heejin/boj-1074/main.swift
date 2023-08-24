import Foundation

let input = readLine()!.split(separator: " ").map{Int(String($0))!}

var(N, r, c) = (input[0], input[1], input[2])
var num = Int(pow(2.0, Float(N)))

var cnt = 0


check(r, c, num)

func check(_ x: Int, _ y: Int, _ size: Int){
    
    if size >= 2 {
        if(x > size/2 - 1) {// 3,4 분면
            if (y > size/2 - 1 ){//4
                cnt += (size * size) * 3/4
                check(x-size/2, y-size/2, size/2)
            }
            else{//3
                cnt += (size * size) * 2/4
                check(x-size/2, y, size/2)
            }
        }
        else {//1,2 분면
            if(y > size/2 - 1){//2
                cnt += (size * size) * 1/4
                check(x, y-size/2, size/2)
            }
            else{//1
                check(x, y, size/2)
            }
        }
    }
}

print(cnt)

