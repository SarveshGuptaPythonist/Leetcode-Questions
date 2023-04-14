import heapq

class MinHeap:
    def __init__(self):
        self.heap = []

    def push(self, val):
        heapq.heappush(self.heap, val)

    def pop(self):
        return heapq.heappop(self.heap)

    def peek(self):
        return self.heap[0] if self.heap else None


class MaxHeap:
    def __init__(self):
        self.heap = []

    def push(self, val):
        heapq.heappush(self.heap, -val)

    def pop(self):
        return -heapq.heappop(self.heap)

    def peek(self):
        return -self.heap[0] if self.heap else None


# implementation
min_heap = MinHeap()
max_heap = MaxHeap()

for val in [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]:
    min_heap.push(val)
    max_heap.push(val)

print("Min Heap:")
while min_heap.peek():
    print(min_heap.pop(), end=" ")
print()

print("Max Heap:")
while max_heap.peek():
    print(max_heap.pop(), end=" ")
print()



Min Heap:
1 1 2 3 3 4 5 5 5 6 9 
Max Heap:
9 6 5 5 5 4 3 3 2 1 1 



# Explanation for minus operation
'''
In a max heap, the largest element should be at the root of the heap. The heapq module in Python provides a heappop function that removes and returns the smallest element in a heap. Therefore, to implement a max heap using heapq, we can negate all the elements when inserting them into the heap, so that the largest element becomes the smallest element after negation.

When popping elements from the max heap, we use heappop to retrieve the smallest element (which is actually the negated largest element), and then negate it again to obtain the actual largest element. This is why we add a negative sign in the pop function of the MaxHeap class in the example code:
This effectively reverses the sign of the smallest element in the heap, making it the largest element. Without negating the values, the heappop function would remove the smallest element from the heap, which would not necessarily be the maximum element in the heap.

In summary, negating the elements in a max heap is a convenient way to use the heapq module to implement a max heap, and adding the negative sign in the pop function allows us to retrieve the actual largest element from the heap.

Yes, by default, the heapq module in Python provides functions to create and manipulate min heaps. This means that the heappush, heappop, and heapify functions provided by the module assume that you are working with
'''
