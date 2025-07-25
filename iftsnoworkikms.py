from qiskit import QuantumCircuit, transpile, Aer, assemble
from qiskit.visualization import plot_histogram
import matplotlib.pyplot as plt
from qiskit_aer import AerSimulator

qc = QuantumCircuit(4, 4)
qc.h(0)
qc.h(2)
qc.cx(0, 1)
qc.cx(2,3)
qc.cx(0,3)
qc.cx(1,2)
qc.x(3)
qc.measure([0,1,2,3], [0,1,2,3])

print(qc.draw())  # ASCII diagram

sim = AerSimulator()
tqc = transpile(qc, sim)
result = sim.run(tqc).result()

counts = result.get_counts()
print(counts)

plot_histogram(counts)
plt.show()
