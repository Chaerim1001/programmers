# https://school.programmers.co.kr/learn/courses/30/lessons/133502

def solution(ingredient):
    value = []
    result = 0
    for i in ingredient:
        value.append(i)
        if value[-4:] == [1, 2, 3, 1]:
            result += 1
            for i in range(4):
                value.pop()
    return result