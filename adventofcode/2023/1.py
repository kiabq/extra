input = open("input.txt", "r");
alpha = {
    "one": 1,
    "two": 2,
    "three": 3,
    "four": 4,
    "five": 5,
    "six": 6,
    "seven":7,
    "eight": 8,
    "nine": 9
}
sum = 0

for line in input.readlines():
    track = []
    num_one = False
    num_two = False
    pos = 0

    # Track all words in line
    #! This is actually not necessary, but I left it in the solution because it was my original approach
    for (key, value) in alpha.items():
        if (pos := line.find(key)) > -1:
            track = [[key, pos]] + track

    # Sort tracked by position
    track = sorted(track, key=lambda x: x[1])

    # Replace words with numbers
    for word in track:
        replaced = word[0][0] + str(alpha[word[0]]) + word[0][-1]
        line = line.replace(word[0], replaced)

    # Get number from line
    for idx, char in enumerate(line):
        if (char.isnumeric()):
            if not num_one:
                num_one = char
            else:
                num_two = char

    # If number is single digit, double its presence in the string
    if not num_two:
        num_two = num_one

    sum += int(num_one + num_two)

print(sum)