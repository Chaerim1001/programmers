# https://school.programmers.co.kr/learn/courses/30/lessons/92334

def solution(id_list, report, k):
    suspect = {}
    report_list = {}
    answer = {}
    result = []
    
    for id in id_list:
        report_list[id] = [] 
        suspect[id] = 0
        answer[id] = 0

    for i in set(report):
        report_list[i.split()[1]].append(i.split()[0])
        suspect[i.split()[1]] += 1
    
    for v in suspect.items():
        if(v[1] >= k):
            for i in report_list[v[0]]: 
                answer[i] += 1
             
    for id in id_list:
        result.append(answer[id])
        
    return result;

# 다른 사람의 풀이
def solution(id_list, report, k):
    answer = [0] * len(id_list)    
    reports = {x : 0 for x in id_list}

    for r in set(report):
        reports[r.split()[1]] += 1

    for r in set(report):
        if reports[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1

    return answer