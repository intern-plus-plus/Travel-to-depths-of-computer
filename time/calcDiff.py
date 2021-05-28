
def diff(start,end):
    seconds = end-start
    sec = seconds%60
    mins = seconds/60
    min = mins%60
    hour = mins/60
    return str(int(hour)) + ":" + str(int(min)) + ":" + str(int(sec))


print(diff(0,86800))