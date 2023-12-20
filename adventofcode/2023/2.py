input = open("input.txt", "r");

games = input.readlines()
winning_sum = 0
power_sum = 0

for game in games:
    split_by_colon = game.split(':')

    game_id = int(split_by_colon[0].split()[1])
    turns = split_by_colon[1].split(';')
    fail = False

    min_r = 0
    min_g = 0
    min_b = 0

    for turn in turns:
        r = 12
        g = 13
        b = 14

        roll = turn.split(', ')

        for results in roll:
            split_results = results.split()

            integer = int(split_results[0])
            color = split_results[1].strip()

            if color == 'red':
                if (integer > min_r):
                    min_r = integer

                r -= integer
            elif color == 'green':
                if (integer > min_g):
                    min_g = integer

                g -= integer
            elif color == 'blue':
                if (integer > min_b):
                    min_b = integer

                b -= integer

        if r < 0 or g < 0 or b < 0:
            fail = True
    
    power_sum += (min_r * min_g * min_b)

    if not fail:
        winning_sum += game_id

print(winning_sum, power_sum)