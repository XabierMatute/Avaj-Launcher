import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import matplotlib.colors as mcolors

# Load the CSV file
data = pd.read_csv('noise_map.csv', header=None)

# Print the shape and first few rows to verify
print("Shape of the DataFrame:", data.shape)
print(data.head())

# Assuming the data is structured as follows:
# Each row represents a coordinate in x and each column a coordinate in y
x = np.arange(data.shape[0])
y = np.arange(data.shape[1])
X, Y = np.meshgrid(y, x)
Z = data.values

# Create a custom colormap
cmap = mcolors.LinearSegmentedColormap.from_list("red_black", ["black", "red"])

# Create a contour plot
plt.figure(figsize=(10, 8))
contour = plt.contourf(X, Y, Z, cmap=cmap)
plt.colorbar(contour, label='Noise Level')
plt.xlabel('Y Coordinate')
plt.ylabel('X Coordinate')
plt.title('Noise Map')
plt.grid(True)
plt.show()