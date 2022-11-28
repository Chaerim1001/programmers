# https://school.programmers.co.kr/learn/courses/30/lessons/118667
# 제일 처음 생각했던 풀이.. 너무 복잡하게 생각한.. 틀리고.. 시간 초과 뜨고..
def solution(queue1, queue2):
    queue = [x for x in queue1]
    
    queue1_sum = 0
    queue2_sum = 0
    size = len(queue1)
    
    for i in range(0, size):
        queue1_sum += queue1[i]
        queue2_sum += queue2[i]
        queue.append(queue2[i])
     
    if queue1_sum == queue2_sum:
        return 0
    
    queue_sum = queue1_sum + queue2_sum
    goal = int(queue_sum / 2)
    
    for i in range(0, size):
        if(queue1[i] > goal or queue2[i] > goal):
            return -1
        
    
    sum = 0
    end_point = 0
    start_point = 0
    index = 0
    
    while(start_point <= len(queue)):
        sum += queue[index]
        if sum == goal:
            end_point = index
            break
        elif sum > goal:
            sum = 0
            start_point += 1
            index = start_point
            continue
        index += 1
        if index >= len(queue):
            index = 0  
    
    if end_point >= size - 1:
        return (end_point - size + 1) + start_point
    elif start_point < size - 1 and end_point < size - 1:
        return end_point + 1 + size + start_point
    else:
        return end_point + start_point - size

# 갈아엎고 다시 생각한 풀이
from collections import deque

def solution(queue1, queue2):
    result = 0
    queue1_sum,queue2_sum = sum(queue1),sum(queue2)

    dq1 = deque(queue1)
    dq2 = deque(queue2)
    
    index = 0
    while index < len(queue1) * 3:
        if queue1_sum < queue2_sum:
            pop = dq2.popleft()
            dq1.append(pop)
            queue1_sum += pop
            queue2_sum -= pop
        elif queue1_sum > queue2_sum:
            pop = dq1.popleft()
            dq2.append(pop)
            queue1_sum -= pop
            queue2_sum += pop
        else:
            return result
            
        result += 1    
        index += 1
        
    return -1