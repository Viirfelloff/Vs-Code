from qiskit import QuantumCircuit, transpile, Aer, assemble
from qiskit.visualization import plot_histogram
import matplotlib.pyplot as plt
from qiskit_aer import AerSimulator

qc = QuantumCircuit(2, 2)
qc.h(0)
qc.cx(0, 1)
qc.measure([0, 1], [0, 1])

print(qc.draw())  # ASCII diagram

sim = AerSimulator()
tqc = transpile(qc, sim)
result = sim.run(tqc).result()

counts = result.get_counts()
print(counts)

plot_histogram(counts)
plt.show()
