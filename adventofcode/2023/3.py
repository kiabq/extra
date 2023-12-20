def main():
    input = open("input.txt", "r")
    parts = input.readlines()
    part_sum = 0

    for idx, part in enumerate(parts):
        current = ""
        in_schematic = False

        # top left = idx - 1, part - 1; top = idx - 1; top right = idx - 1, part + 1
        # left = part - 1; right = part + 1
        # bottom left = idx + 1; part -1; bottom = idx + 1; bottom right = idx + 1, part + 1

        for jdx, char in enumerate(part):  
            if char.isnumeric():
                current += char
                for i in range(-1, 2):
                    for j in range(-1, 2):
                        try:
                            symbol = parts[idx + i][jdx + j]
                            print(symbol)
                            if not symbol.isnumeric() and symbol != "." and symbol != "\n":
                                in_schematic = True
                        except:
                            continue

            else:
                if in_schematic:
                    part_sum += int(current)
                    in_schematic = False

                current = ""

    print(part_sum)

if __name__ == "__main__":
    main()