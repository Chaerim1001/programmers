# https://school.programmers.co.kr/learn/courses/30/lessons/136798

# 시간 초과 뜬 첫번째 풀이
def solution(number, limit, power):
    count = [0] * number
    result = 0
    for num in range(1, number+1):
        for i in range(1, num+1):
            if(num % i == 0):
                count[num-1] += 1
            if(count[num-1] > limit):
                count[num-1] = power
                break
       
    for i in count:
        result += i
    
    return result

# 수정한 풀이 --> 제곱근 활용
def solution(number, limit, power):
    count = [0] * number
    result = 0 
    for num in range(1, number+1):
        for i in range(1, int(num ** 0.5) + 1):
            if num % i == 0:
                count[num-1] += 1
                if i ** 2 != num:
                    count[num-1] += 1
            if count[num-1] > limit:
                count[num-1] = power
                break
       
    for i in count:
        result += i
    
    return result