import numpy as np
import matplotlib.pyplot as plt
plt.style.use('seaborn')


y_axis = [2.571, 5.571, 31.857, 397418.714]
x_axis = [2,4,16,65536]

plt.figure(dpi=200)
plt.plot(x_axis,y_axis,marker='o')


for x,y in zip(x_axis,y_axis):
    label = "{:.2f}".format(np.log2(y))

    plt.annotate(label, # this is the text
                 (x,y), # this is the point to label
                 textcoords="offset points", # how to position the text
                 xytext=(0,10), # distance from text to points (x,y)
                 ha='center') # horizontal alignment can be left, right or center


plt.xlabel('log N', fontsize=18)
plt.xscale('log', base=2)

plt.ylabel('log M', fontsize=18)
plt.yscale('log', base=2)


plt.yticks(ticks= y_axis, labels=[int(np.log2(y)) for y in y_axis])
plt.xticks(ticks= x_axis, labels=[int(np.log2(x)) for x in x_axis])

y_axis = [2.571, 5.571, 31.857, 397418.714]
x_axis = [2,4,16,65536]

avg = sum([np.log2(y)/np.log2(x) for y,x in zip(y_axis,x_axis)])/len(x_axis)
print('Slope',avg)





