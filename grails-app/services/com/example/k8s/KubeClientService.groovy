package com.example.k8s

import io.fabric8.kubernetes.api.model.Pod
import io.fabric8.kubernetes.api.model.batch.v1.Job
import io.fabric8.kubernetes.client.KubernetesClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

import java.time.Instant
import java.time.format.DateTimeFormatter

class KubeClientService {
    @Value('${test.namespace.filter}')
    List<String> namespaceFilter

    @Autowired
    KubernetesClient client

    Job getJob(String namespace, String jobName) {
        client.batch().v1().jobs().inNamespace(namespace).withName(jobName).get()
    }

    Pod getLastPodForJob(Job job) {
        List<Pod> pods = client.pods().inNamespace(job.metadata.namespace).withLabel('controller-uid', job.metadata.uid).list().items
        pods.toSorted { Pod a, Pod b ->
            DateTimeFormatter.ISO_INSTANT.parse(b.metadata.creationTimestamp, Instant::from).toEpochMilli() <=> DateTimeFormatter.ISO_INSTANT.parse(a.metadata.creationTimestamp, Instant::from).toEpochMilli()
        }[0]
    }
}