package com.example.applymate.presentation.components.resume

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applymate.R
import com.example.applymate.common.UiState
import com.example.applymate.presentation.components.core.DocumentUploader
import com.example.applymate.presentation.viewModel.DocumentViewModel
import com.example.applymate.utils.createRequestBodyFromString
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

//TODO: Give option to select if text or pdf or something
@Composable
fun UploadResumeDocument(
    viewModel: DocumentViewModel
) {
    val context = LocalContext.current

    DocumentUploader(
        image = R.drawable.resume_selected,
        imageDesc = "Resume"
    ) { fileUri ->
        val file = uriToFile(context, fileUri)
        val fileRequestBody = file.asRequestBody("application/pdf".toMediaTypeOrNull())
        val filePart = MultipartBody.Part.createFormData("document", file.name, fileRequestBody)

        val type = createRequestBodyFromString("pdf")
        val prompt = createRequestBodyFromString("Just extract the text from the document")
        val txt = createRequestBodyFromString("")

        viewModel.getDocumentText(filePart, type, prompt, txt, "resume")
    }

    Spacer(Modifier.height(16.dp))

    DocumentUploader(
        image = R.drawable.job_upload,
        imageDesc = "Job Description"
    ) { fileUri ->
        val file = uriToFile(context, fileUri)
        val fileRequestBody = file.asRequestBody("application/pdf".toMediaTypeOrNull())
        val filePart = MultipartBody.Part.createFormData("document", file.name, fileRequestBody)

        val type = createRequestBodyFromString("pdf") // differentiate using this
        val prompt = createRequestBodyFromString("Just extract the text from the document")
        val txt = createRequestBodyFromString("")

        viewModel.getDocumentText(filePart, type, prompt, txt, "jd")
    }
}

fun uriToFile(context: Context, uri: Uri): File {
    val inputStream = context.contentResolver.openInputStream(uri)
    val file = File(context.cacheDir, "temp_upload_file")
    inputStream?.use { input ->
        file.outputStream().use { output ->
            input.copyTo(output)
        }
    }
    return file
}