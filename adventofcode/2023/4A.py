input = open("input.txt", "r")
cards = input.readlines()

def main():
    card_sum = 0

    for card in cards:
        card_name = card.split(":")[0]
        all_numbers = card.split(":")[1]
        split_numbers = all_numbers.split("|")
        winning_numbers = split_numbers[0].split()
        own_numbers = split_numbers[1].strip('\n').split()

        matching = {}
        matching_amount = 0
        matching_value = 1

        for number in winning_numbers:
            matching[number] = 1

        for number in own_numbers:
            if (matching.get(number)):
                matching_amount += 1

        if not matching_amount:
            pass
        else:
            if matching_amount > 1:
                temp = 0

                for i in range(matching_amount):
                    temp = matching_value << i
                
                matching_value = temp
            
            card_sum += matching_value

    print(card_sum)

if __name__ == "__main__":
    main()