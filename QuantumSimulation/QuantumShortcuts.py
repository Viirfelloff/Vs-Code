from qiskit.visualization import plot_histogram
import matplotlib.pyplot as plt
from qiskit_aer import AerSimulator
from qiskit import QuantumCircuit, transpile
def displayInfo(qc : QuantumCircuit):
    print(qc.draw())
    sim = AerSimulator()
    tqc = transpile(qc, sim)
    result = sim.run(tqc).result()

    counts = result.get_counts()
    print(counts)

    plot_histogram(counts)
    plt.show()
def create(qubits,cbits):
    return QuantumCircuit(qubits, cbits)
