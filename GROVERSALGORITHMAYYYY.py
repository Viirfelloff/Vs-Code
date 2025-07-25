from qiskit import Aer, transpile, assemble, QuantumCircuit
import matplotlib as plt
from qiskit_aer import AerSimulator
from qiskit.visualization import plot_histogram

#Step 0: Initialize
qc = QuantumCircuit(2)

#Step 1: Apply Hadamard Gate to all Qubits
qc.h([0,1])

#Step 2: Oracle Operator (Sign Change)
qc.cz(0,1)

#Step 3: Diffusion
qc.h([0, 1])
qc.x([0, 1])
qc.h(1)
qc.cx(0, 1)
qc.h(1)
qc.x([0, 1])
qc.h([0, 1])

#do thsi tmrw bc gpt sucks at eplxinnig. DO IT THO FR. 7/25.