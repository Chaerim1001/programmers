# https://school.programmers.co.kr/learn/courses/30/lessons/72410
import re

def solution(new_id):
    step_1 = new_id.lower()
    
    step_2 = re.sub('[^a-z0-9\-_.]', '', step_1)
    
    step_3 = step_2.replace('..','.')
    while(step_3.find('..') != -1):
        step_3 = step_3.replace('..','.')
        
    step_4 = step_3.strip('.')

    if len(step_4) == 0:
        step_5 = 'a'
    else:
        step_5 = step_4
    
    if len(step_5) > 15:
        step_6 = step_5[:15].strip('.')
    else:
        step_6 = step_5
    
    step_7 = step_6
    
    if len(step_7) < 3:
        while len(step_7) < 3:
            step_7 += step_7[-1]
    
    return step_7

# 다른 사람의 풀이
import re

def solution(new_id):
    st = new_id
    st = st.lower()
    st = re.sub('[^a-z0-9\-_.]', '', st)
    st = re.sub('\.+', '.', st)
    st = re.sub('^[.]|[.]$', '', st)
    st = 'a' if len(st) == 0 else st[:15]
    st = re.sub('^[.]|[.]$', '', st)
    st = st if len(st) > 2 else st + "".join([st[-1] for i in range(3-len(st))])
    return st