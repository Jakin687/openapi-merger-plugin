package com.rameshkp.openapi.merger.app.mergers

import io.swagger.v3.oas.models.OpenAPI

class WebhooksMerger: PathsMerger() {
    override fun get(): OpenApi {
        val webhook = OpenApi()
        map.forEach { (key, value) ->  webhook.addWebhooks(key, value)}
        return webhook
    }
}
