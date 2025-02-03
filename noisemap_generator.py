import numpy as np
import matplotlib.pyplot as plt
import matplotlib.colors as mcolors
from noise import pnoise2
import random

# Definir las dimensiones del mapa
WIDTH = 100
HEIGHT = 100
SCALE = 10.0

# Definir los tipos de clima y sus colores
WEATHER_TYPES = {
    'clear': '#FFD700',  # Dorado
    'cloudy': '#B0C4DE',  # Azul claro
    'rainy': '#4682B4',  # Azul acero
    'stormy': '#000080'  # Azul marino
}

def get_weather(value):
    if value < 0.42:
        return 'clear'
    elif value < 0.6:
        return 'cloudy'
    elif value < 0.80:
        return 'rainy'
    else:
        return 'stormy'

# Generar una semilla aleatoria
seed = random.randint(0, 10000)

# Generar el mapa
weather_map = np.empty((WIDTH, HEIGHT), dtype=object)
for x in range(WIDTH):
    for y in range(HEIGHT):
        # Generar un valor de ruido Perlin para cada punto
        noise_value = pnoise2(x / SCALE, y / SCALE, octaves=4, persistence=0.5, lacunarity=2.0, repeatx=WIDTH, repeaty=HEIGHT, base=seed)
        # Normalizar el ruido a rango [0, 1]
        normalized_value = (noise_value + 0.5) / 1.0
        # Asignar clima
        weather_map[x, y] = get_weather(normalized_value)

# Crear la visualización
color_map = np.empty((WIDTH, HEIGHT, 3))
for x in range(WIDTH):
    for y in range(HEIGHT):
        weather = weather_map[x, y]
        color_map[x, y] = mcolors.to_rgb(WEATHER_TYPES[weather])

# Mostrar el mapa
plt.figure(figsize=(10, 10))
plt.imshow(color_map, interpolation='nearest')
plt.title("Mapa de Climas (100x100)")
plt.axis("off")

# Guardar el mapa como archivo de imagen
plt.savefig("noise_map.png", format="png")

# Mostrar el mapa
plt.show()