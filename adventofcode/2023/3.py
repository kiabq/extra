def main():
    input = open("input.txt", "r")
    parts = input.readlines()
    part_sum = 0
    gear_ratio = 0
    gears = {}

    for idx, part in enumerate(parts):
        current = ""
        in_schematic = False
        found = {}

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
                            
                            if not symbol.isnumeric() and symbol != "." and symbol != "\n":
                                found = (idx + i, jdx + j)
                                in_schematic = True
                        except:
                            continue

            else:
                if in_schematic:
                    if gears.get(found):
                        gears[found] = gears[found] + [current]
                    else:
                        gears[found] = [current]

                    part_sum += int(current)
                    in_schematic = False

                current = ""

    for key in gears:
        gear_length = len(gears[key])
        prefix = 1

        if gear_length > 1:
            for i in range(gear_length):
                prefix *= int(gears[key][i])

            gear_ratio += prefix
        
    print(gear_ratio)
    print(part_sum)

if __name__ == "__main__":
    main()