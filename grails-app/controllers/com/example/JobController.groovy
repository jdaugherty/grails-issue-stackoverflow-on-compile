package com.example

import com.example.k8s.KubeClientService
import grails.compiler.GrailsCompileStatic
import io.fabric8.kubernetes.api.model.Pod
import io.fabric8.kubernetes.api.model.batch.v1.Job

@GrailsCompileStatic
class JobController {

    KubeClientService kubeClientService

    //@CompileDynamic // TODO: the map return causes a stackoverflow error when this controller is compile static
    def show(String jobNamespace, String jobName) {
        Job job = kubeClientService.getJob(jobNamespace, jobName)
        Pod lastPod = kubeClientService.getLastPodForJob(job)
        [name: jobName, job: job, lastPod: lastPod]
    }
}