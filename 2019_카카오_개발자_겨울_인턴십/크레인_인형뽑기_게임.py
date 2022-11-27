# https://school.programmers.co.kr/learn/courses/30/lessons/64061
def solution(board, moves):
    box = []
    result = 0
    game_board = {x: [] for x in range(1, len(board) + 1)}
    
    for index in range(0, len(board)):
        for b in board:
            if b[index] != 0:
                game_board[index + 1].append(b[index])
    
    for move in moves:
        if len(game_board[move]) != 0:
            target = game_board[move].pop(0)
            if len(box) != 0:
                if target != box[-1]:
                    box.append(target)
                else:
                    box.pop(-1)
                    result += 2
            else:
                box.append(target)

    return result        
    
# 다른 사람의 풀이
def solution(board, moves):
    stacklist = []
    answer = 0

    for i in moves:
        for j in range(len(board)):
            if board[j][i-1] != 0:
                stacklist.append(board[j][i-1])
                board[j][i-1] = 0

                if len(stacklist) > 1:
                    if stacklist[-1] == stacklist[-2]:
                        stacklist.pop(-1)
                        stacklist.pop(-1)
                        answer += 2     
                break

    return answer