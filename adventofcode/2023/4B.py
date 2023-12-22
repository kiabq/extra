input = open("input.txt", "r")
cards = input.readlines()

def main():
    card_sum = 0
    card_track = {}

    for idx, card in enumerate(cards):
        card_name = card.split(":")[0]
        card_number = int(card_name.split()[1])
        all_numbers = card.split(":")[1]
        split_numbers = all_numbers.split("|")
        winning_numbers = split_numbers[0].split()
        own_numbers = split_numbers[1].strip('\n').split()

        matching = {}
        matching_amount = 0

        for number in winning_numbers:
            matching[number] = 1

        for number in own_numbers:
            if (matching.get(number)):
                matching_amount += 1

        print(card_name)
        if matching_amount > 0:
            for i in range(matching_amount + 1):
                if (card_track.get(card_number + i)):
                    card_track[card_number + i] += 1
                else:
                    card_track[card_number + i] = 1

    print(card_track)
    

if __name__ == "__main__":
    main()