from collections import deque

def breadth_first(name):
    graph = {}
    graph["you"] = ["alice", "bob", "claire"]
    graph["bob"] = ["anuj", "peggy"]
    graph["alice"] = ["peggy"]
    graph["claire"] = ["jonny"]
    graph["anuj"] = []
    graph["jonny"] = []
    graph["peggy"] = []

    search_queue = deque()
    search_queue += graph["you"]
    searched = []

    while search_queue:
        person = search_queue.popleft()
        if not person in searched:
            if person_is_seller(person):
                print(person + " is a mango seller!")
                return True
            else:
                search_queue += graph[person]
                searched.append(person)

    print("there is no mango seller!")
    return False

def person_is_seller(person):
    return person[-1] == 'm'

breadth_first("you")