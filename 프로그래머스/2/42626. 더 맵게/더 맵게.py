import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    canMake = True
    while scoville[0] < K:
        if len(scoville) == 1:
            canMake = False
            break
            
        food1 = heapq.heappop(scoville)
        food2 = heapq.heappop(scoville)
        
        heapq.heappush(scoville, food1 + food2 * 2)
        answer += 1
    
    return answer if canMake else -1