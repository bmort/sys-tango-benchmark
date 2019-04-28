import numpy as np

from multiprocessing import Queue

from . import utils

from tangobenchmarks.client.python.pipe_write import Worker as WriteWorker
from tangobenchmarks.utility.benchmark import common_main


class WritePipeBenchmark(utils.Benchmark):
    """  master class for pipe benchmark
    """

    def __init__(self, options):
        """ constructor

        :param options: commandline options
        :type options: :class:`argparse.Namespace`
        """

        utils.Benchmark.__init__(self)

        __value = (
            'PipeBlob',
            [
                {'name': 'DevLong64', 'value': 123, },
                {'name': 'DevULong', 'value': np.uint32(123)},
                {'name': 'DevVarUShortArray',
                 'value': range(5), 'dtype': ('uint16',)},
                {'name': 'DevVarDoubleArray',
                 'value': [1.11, 2.22], 'dtype': ('float64',)},
                {'name': 'DevBoolean', 'value': True},
            ]
        )
        #: (:obj:`list` < :class:`multiprocessing.Queue` >) result queues
        self._qresults = [Queue() for i in range(options.clients)]

        size = max(1, int(options.size))
        value1 = (__value[1] *
                  (size // max(1, len(__value[1]) - 1) + 1))[:size]

        for i in range(len(value1)):
            value1[i] = dict(value1[i])
            value1[i]["name"] = str(i) + "_" + value1[i]["name"]

        __value = __value[0], tuple(value1)

        #: (:obj:`list` < :class:`Worker` >) process worker
        self._workers = [
            WriteWorker(i, q, options, value=__value)
            for i, q in enumerate(self._qresults)
        ]


def _add_arguments(parser):
    parser.add_argument(
        "-i", "--pipe", dest="pipe",
        default="BenchmarkPipe",
        help="pipe which will be read/write, default: BenchmarkPipe")
    parser.add_argument(
        "-s", "--size", dest="size",
        default="1",
        help="pipe size, default: 1, e.g. -s 134 ")


def _update_options(options):
    if not options.pipe:
        options.pipe = "BenchmarkPipe"


def main(**kargs):
    common_main(
        kargs,
        _add_arguments,
        _update_options,
        benchmark_class=WritePipeBenchmark,
        description=(
            'perform check if and how a number of simultaneous '
            'clients affect pipes write speed'),
        title="Pipe Write Benchmark",
        header_text="write")


if __name__ == "__main__":
    main()
